# The RatFood


## How to install ?
The project need Docker in your local machine for launch, so before running the project you need to install it.

### Install Docker
#### - Linux
     > sudo apt install docker
     > sudo apt install docker-compose
     > sudo reboot

#### - Windows
    - Download Docker windows installer: https://download.docker.com/win/beta/InstallDocker.msi


After Docker's installation, you should put your **.env** in laravel folder

To launch the project do : 
```
cd docker && chmod +x init.sh && ./init.sh && chmod +x smartFix.sh && ./smartFix.sh
```
![RatFood](https://media.discordapp.net/attachments/896700404610506782/950072961384206376/Screenshot_20220306-175034_RatFoodApp.jpg?width=305&height=678 "RatFood")
![RatFoodRest](https://media.discordapp.net/attachments/896700404610506782/950080816296366110/Screenshot_20220306-182142_RatFoodApp.jpg?width=305&height=678 "RatFoodRest")

### Before doing unit tests, please do : 
```
cd docker && docker exec rat_php php artisan migrate:fresh --seed
```