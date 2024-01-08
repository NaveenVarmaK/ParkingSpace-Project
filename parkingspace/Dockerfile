# Use an official Node.js runtime as a base image
FROM node:14

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install app dependencies
RUN npm install

# Copy the rest of the application code to the working directory
COPY . .

# Expose the port your app runs on (default is 8080 for Vue.js)
EXPOSE 8080

# save the env variables in the image
# RUN echo "${FRONTEND_PORT}"
ARG FRONTEND_PORT
ARG SPRINGBOOT_PORT

ENV FRONTEND_PORT=${FRONTEND_PORT}
ENV SPRINGBOOT_PORT=${SPRINGBOOT_PORT}
RUN echo "Value of FRONTEND_PORT: $FRONTEND_PORT"
RUN echo "Value of SPRINGBOOT_PORT: $SPRINGBOOT_PORT"


# RUN echo "${SPRINGBOOT_PORT}"
RUN echo "FRONTEND_PORT=${FRONTEND_PORT}" >> .env
RUN echo "SPRINGBOOT_PORT=${SPRINGBOOT_PORT}" >> .env

# script to write env variables to a java script file
RUN echo "const FRONTEND_PORT = ${FRONTEND_PORT};" >> /usr/src/app/src/services/EnvVariables.js
RUN echo "console.log('FRONTEND_PORT: ' + FRONTEND_PORT);" >> /usr/src/app/src/services/EnvVariables.js
RUN echo "const SPRINGBOOT_PORT = ${SPRINGBOOT_PORT};" >> /usr/src/app/src/services/EnvVariables.js
RUN echo "console.log('SPRINGBOOT_PORT: ' + SPRINGBOOT_PORT);" >> /usr/src/app/src/services/EnvVariables.js

# COPY ./startup.sh startup.sh

# EXPORT EVN VARIABLES and run the app
# CMD ["export $(grep -v '^#' .env | xargs -0)", "&&", "npm", "run", "serve]
# CMD ["export " "&&", "npm", "run", "serve"]
# CMD ["./startup.sh"]
# CMD ["/bin/bash", "-c", "export $(grep -v '^#' .env | xargs) && npm run serve"]
CMD ["npm", "run", "serve"]
