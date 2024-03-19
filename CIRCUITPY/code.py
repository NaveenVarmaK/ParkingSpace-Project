import time
import board
import busio
import digitalio
import adafruit_ble
from adafruit_ble.advertising import Advertisement
from adafruit_ble.advertising.standard import ProvideServicesAdvertisement
from adafruit_ble.services.nordic import UARTService
import adafruit_apds9960.apds9960
import adafruit_requests as requests

# Initialize BLE radio
ble = adafruit_ble.BLERadio()

# Create UART service
uart = UARTService()
advertisement = ProvideServicesAdvertisement(uart)

# Set device name in the advertisement
advertisement.complete_name = "NRF52"

# Initialize the APDS9960 sensor
i2c = busio.I2C(board.SCL, board.SDA)
sensor = adafruit_apds9960.apds9960.APDS9960(i2c)
sensor.enable_proximity = True

# Define backend server details
backend_ip = "192.168.0.105"
backend_port = 8084
endpoint = "/api/carparks/1/updateStatus"  # Assuming car park ID is 1

# Main loop
while True:
    try:
        # Advertising
        ble.start_advertising(advertisement)
        print("Advertising...")
        while not ble.connected:
            pass
        ble.stop_advertising()
        print("Advertisement stopped")
        print("Connected!")

        # Wait for disconnection
        while ble.connected:
            # Read proximity sensor value
            proximity = sensor.proximity

            # Determine status based on proximity reading
            if proximity != 0:
                status = "busy"
            else:
                status = "available"
            
            # Example: Make a POST request to backend API
            url = f"http://{backend_ip}:{backend_port}{endpoint}"
            response = requests.post(url, json={"status": status})
            print("API Response:", response.text)
            response.close()  # Close the response to free resources

            # Delay before the next reading
            time.sleep(30)
            
        print("Disconnected!")

    except Exception as e:
        print("Error:", e)

    # Add a delay to prevent auto-reload interruption
    time.sleep(1)
