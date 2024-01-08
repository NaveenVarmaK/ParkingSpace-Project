export $(grep -v '^#' .env | xargs -0)
npm run serve