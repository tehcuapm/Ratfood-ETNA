<?php

namespace Database\Seeders;

use App\Models\Restaurant;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class RestaurantSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('restaurants')->insert([
            "name" => "O souvennirs de Theoss",
            "description" => "Un restoran servend de nombreu plas issu du Theoss. Pris acessible et plas pour toute la famill !",
            "grade" => 2.7,
            "localisation" => "117 Bd Poniatowski, 75012 Paris",
            "website" => "osouvenirtheos.com"
        ]);

        DB::table('restaurants')->insert([
            "name" => "RatKing",
            "description" => "Un fastfood incontournable issu des Etat Unino, prix les plus bas comparé à la concurrence.",
            "grade" => 4.1,
            "localisation" => "11 Av. du Président Salvador Allende, 94400 Vitry-sur-Seine",
            "website" => "Ratking_eat.com"
        ]);

        DB::table('restaurants')->insert([
            "name" => "Délices des îles",
            "description" => "Des délices variées des îles Julles, le contrast entre tradition et innovation garantiront le plaisir des petits et grands !",
            "grade" => 4.6,
            "localisation" => "15 Parvis De La Défense, Pl. du Dôme Niv 3, 92800 Puteaux",
            "website" => "Restaurant_advisor/delice_des_iles.com"
        ]);

        DB::table('restaurants')->insert([
            "name" => "Innov'Joh",
            "description" => "Des plats divers et variée repris de traditions Johllandaise.",
            "grade" => 1.0,
            "localisation" => "36 Rue du Roi de Sicile, 75004 Paris",
            "website" => "Innovjoh.com"
        ]);

        DB::table('restaurants')->insert([
            "name" => "Kilian Fried Chicken",
            "description" => "Sucesseur du restaurant homonyme le Kilian Fried Chicken propose des recettes fast-food à partir des plats des îles llian.",
            "grade" => 3.6,
            "localisation" => "34 Av. Youri Gagarine, 94400 Vitry-sur-Seine",
            "website" => "KFC2/vitry_sur_seine.com"
        ]);

        DB::table('restaurants')->insert([
            "name" => "Les trois baguettes",
            "description" => "Les trois baguettes propose des plats issus de la culture Quentonaise. Entre divers plats, sauces et brochettes, ce restaurant est apprécie du grand public !",
            "grade" => 4.1,
            "localisation" => "41 Rue Marat, 94200 Ivry-sur-Seine",
            "website" => "Les_3_baguettes.com"
        ]);
    }
}
