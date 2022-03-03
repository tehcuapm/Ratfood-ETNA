<?php

namespace Database\Seeders;

use App\Models\Restaurant;
use Illuminate\Database\Seeder;
use App\Models\User;
use App\Models\Menu;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
        User::factory(15)->create();

        Restaurant::create([
            "name" => "O souvennirs de Theoss",
            "description" => "Un restoran servend de nombreu plas issu du Theoss. Pris acessible et plas pour toute la famill !",
            "grade" => 2.7,
            "localisation" => "117 Bd Poniatowski, 75012 Paris",
            "phone_number" => "01_68_97_12_48",
            "image" => "https://cdn.discordapp.com/attachments/457484268319539211/949078678350991420/zegz.jpg",
            "website" => "osouvenirtheos.com",
            "hour" => "12h-23h"
        ]);

        Restaurant::create([
            "name" => "RatKing",
            "description" => "Un fastfood incontournable issu des Etat Unino, prix les plus bas comparé à la concurrence.",
            "grade" => 4.1,
            "localisation" => "11 Av. du Président Salvador Allende, 94400 Vitry-sur-Seine",
            "phone_number" => "01_46_23_57_98",
            "image" => "https://cdn.discordapp.com/attachments/457484268319539211/949077278376230992/zeg.jpg",
            "website" => "Ratking_eat.com",
            "hour" => "9h-0h"
        ]);

        Restaurant::create([
            "name" => "Délices des îles",
            "description" => "Des délices variées des îles Julles, le contrast entre tradition et innovation garantiront le plaisir des petits et grands !",
            "grade" => 4.6,
            "localisation" => "15 Parvis De La Défense, Pl. du Dôme Niv 3, 92800 Puteaux",
            "phone_number" => "01.45.43.18.76",
            "image" => "https://cdn.discordapp.com/attachments/457484268319539211/949081434822438912/mauri.jpeg",
            "website" => "Restaurant_advisor/delice_des_iles.com",
            "hour" => "12h-0h"
        ]);

        Restaurant::create([
            "name" => "Innov'Joh",
            "description" => "Des plats divers et variés repris de traditions Johllandaise.",
            "grade" => 1.0,
            "localisation" => "36 Rue du Roi de Sicile, 75004 Paris",
            "phone_number" => "01.74.13.42.85",
            "image" => "https://cdn.discordapp.com/attachments/457484268319539211/949081797789098004/joh.jpeg",
            "website" => "Innovjoh.com",
            "hour" =>  "12h-0h"
        ]);

        Restaurant::create([
            "name" => "Kilian Fried Chicken",
            "description" => "Sucesseur du restaurant homonyme le Kilian Fried Chicken propose des recettes fast-food à partir des plats des îles llian.",
            "grade" => 3.6,
            "localisation" => "34 Av. Youri Gagarine, 94400 Vitry-sur-Seine",
            "phone_number" => "01.35.61.78.52",
            "image" => "https://cdn.discordapp.com/attachments/457484268319539211/949082077687578634/kfc.jpg",
            "website" => "KFC2/vitry_sur_seine.com",
            "hour" => "10h-23h"
        ]);

        Restaurant::create([
            "name" => "Les trois baguettes",
            "description" => "Les trois baguettes propose des plats issus de la culture Quentonaise. Entre divers plats, sauces et brochettes, ce restaurant est apprécie du grand public !",
            "grade" => 4.1,
            "localisation" => "41 Rue Marat, 94200 Ivry-sur-Seine",
            "phone_number" => "01.23.28.91.55",
            "image" => "https://cdn.discordapp.com/attachments/457484268319539211/949082536749989939/quentin.jpg",
            "website" => "Les_3_baguettes.com",
            "hour" => "12h30-23h30"
        ]);


        /**
         * Seeders for menus
         */

        Menu::create([
            "name" => "Menu Port o aulives",
            "description" => "Un trais bon plas d'aurigin Theoss, praiparé depui des anné dans nos cuisins",
            "price" => 15.9,
            "id_rest" => Menu::getIdRest(1)
        ]);

        Menu::create([
            "name" => "Menu mouzaka au oberjine",
            "description" => "Tradission Theoss, ce pla garni au oberjine fera pleizir au peti et au gran",
            "price" => 13.8,
            "id_rest" => Menu::getIdRest(1)
        ]);

        Menu::create([
            "name" => "Menu sallad Theoss",
            "description" => "Salad a bat pri, pour lai petite daipense mai toutefoi gourmen !",
            "price" => 6.9,
            "id_rest" => Menu::getIdRest(1)
        ]);

        Menu::create([
            "name" => "Menu Burgir avec supplément Coca",
            "description" => "Le Menu Burgir de Ratking est préparé par nos plus grand soins pour satisfaire la demande toujours plus conséquente de nos chers clients.",
            "price" => 3.9,
            "id_rest" => Menu::getIdRest(2)
        ]);

        Menu::create([
            "name" => "Menu boulette du rat avec supplément Coca",
            "description" => "Les boulettes du rat ne portent pas forcément leur nom que du client qui les achètent..",
            "price" => 0.5,
            "id_rest" => Menu::getIdRest(2)
        ]);

        Menu::create([
            "name" => "Menu REST",
            "description" => "Le Menu REST au plus bas prix satisferont les petites faims qui n'ont pas peur de manger après les autres !",
            "price" => 0.1,
            "id_rest" => Menu::getIdRest(2)
        ]);

        Menu::create([
            "name" => "Menu Chili Con Carne au knacki",
            "description" => "La spécialité connu de tous revisité avec des délicieuses knacki !",
            "price" => 8.5,
            "id_rest" => Menu::getIdRest(3)
        ]);

        Menu::create([
            "name" => "Menu ketchup aux pâtes",
            "description" => "Comme de nombreux autres recettes, c'est parfois en faisant des erreurs que l'on innove !",
            "price" => 3.9,
            "id_rest" => Menu::getIdRest(3)
        ]);

        Menu::create([
            "name" => "Menu Tartine de Burger sauce burger",
            "description" => "Pour simplifier et pour une meilleure dégustation, notre burger est séparé",
            "price" => 8.9,
            "id_rest" => Menu::getIdRest(4)
        ]);

        Menu::create([
            "name" => "Menu Couscous aromatisé au miel",
            "description" => "Pour plus de saveurs et d'arômes nous avons ajouté du miel.",
            "price" => 12.5,
            "id_rest" => Menu::getIdRest(4)
        ]);

        Menu::create([
            "name" => "Menu poulet carbonnisé avec son lit de braises",
            "description" => "Des cuisses de poulet trop cuite et des pommes de terres noires de cuissons",
            "price" => 11.9,
            "id_rest" => Menu::getIdRest(5)
        ]);

        Menu::create([
            "name" => "Menu cuisse de poulet cendrée",
            "description" => "Ce menu est cuit dans les restes de cendres des autres plats ratés pour un goût de fumé prononcé !",
            "price" => 9.9,
            "id_rest" => Menu::getIdRest(5)
        ]);

        Menu::create([
            "name" => "Menu brochette boeuf fromage au cantal",
            "description" => "Reprise du plat à inspiration Quentonaise avec du cantal !",
            "price" => 6.9,
            "id_rest" => Menu::getIdRest(6)
        ]);

        Menu::create([
            "name" => "Menu Riz Quentonais",
            "description" => "Riz avec dès de jambons, oeuf et petits pois.",
            "price" => 9.5,
            "id_rest" => Menu::getIdRest(6)
        ]);
    }
}
