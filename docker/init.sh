docker-compose up -d --build --remove-orphans
sudo chown -R $USER ../ratfood
chmod -R www-data:www-data ../ratfood/storage
docker-compose up