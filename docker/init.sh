docker-compose up -d --build --remove-orphans
sudo chown -R $USER ../ratfood
chmod -R 777 ../ratfood/storage
docker-compose up