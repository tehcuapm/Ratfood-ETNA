<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations;

class Menu extends Model
{
    use HasFactory;

    protected $connection = 'mongodb';
    protected $fillable = [
        "name",
        "description",
        "price"
    ];

    public function getJWTIdentifier()
    {
        return $this->getKey();
    }
}
