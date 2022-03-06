<?php

namespace App\Models;

use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Jenssegers\Mongodb\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Laravel\Sanctum\HasApiTokens;
use Tymon\JWTAuth\Contracts\JWTSubject;
use Jenssegers\Mongodb\Eloquent\Model;

class Menu extends Model
{
    use HasApiTokens, HasFactory, Notifiable;

    protected $connection = 'mongodb';
    protected $fillable = [
        "name",
        "description",
        "price",
        "id_rest",
    ];

    static public function getIdRest($num) {
        switch ($num) {
            case 1:
                $Rest = Restaurant::where('name', '=', 'O souvennirs de Theoss')->first();
                break;
            case 2:
                $Rest = Restaurant::where('name', '=', 'RatKing')->first();
                break;
            case 3:
                $Rest = Restaurant::where('name', '=', 'Délices des îles')->first();
                break;
            case 4:
                $Rest = Restaurant::where('name', '=', 'Innov\'Joh')->first();
                break;
            case 5:
                $Rest = Restaurant::where('name', '=', 'Kilian Fried Chicken')->first();
                break;
            case 6:
                $Rest = Restaurant::where('name', '=', 'Les trois baguettes')->first();
                break;
            case 7:
                $Rest = Restaurant::where('name', '=', 'Au petit grain de sable')->first();
                break;
            case 8:
                $Rest = Restaurant::where('name', '=', 'Boum-appétit')->first();
                break;     
        }
        return $Rest["_id"];
    }
    
}
