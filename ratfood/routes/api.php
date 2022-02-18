<?php

use App\Http\Controllers\AuthController;
use App\Http\Controllers\RestController;
use App\Http\Controllers\MenuController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::group([
    'middleware' => 'api',
], function ($router) {
    Route::post('/register', [AuthController::class, 'register']);
    Route::post('/auth', [AuthController::class, 'login']);
    Route::get('/users', [AuthController::class, 'allUsers']);
    Route::post('/sign_out', [AuthController::class, 'sign_out']);
    Route::get('/restaurants', [RestController::class, 'allRestaurants']);
    Route::post('/restaurant', [RestController::class, 'createRestaurant']);
    Route::put('/restaurant/{id}', [RestController::class, 'putRestaurant']);
    Route::delete('/restaurant/{id}', [RestController::class, 'deleteRestaurant']);
    Route::get('/restaurant/{id}/menus', [MenuController::class, 'allMenu']);
    Route::post('/restaurant/{id}/menu', [MenuController::class, 'createMenu']);
    Route::put('/restaurant/{id}/menu/{id_menu}', [MenuController::class, 'updateMenu']);
    Route::delete('/restaurant/{id}/menu/{id_menu}', [MenuController::class, 'deleteMenu']);
});
