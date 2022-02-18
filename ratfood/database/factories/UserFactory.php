<?php

namespace Database\Factories;

use App\Models\User;
use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Str;

class UserFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array
     */
    protected  $model = User::class;

    public function definition()
    {
        return [
            'username' =>$this->faker->username(),
            'firstname' =>$this->faker->firstname(),
            'name' => $this->faker->name(),
            'email' => $this->faker->unique()->safeEmail(),
            'age' =>$this->faker->randomDigitNotZero(),
            'password' => "123456", // password

        ];
    }

    /**
     * Indicate that the model's email address should be unverified.
     *
     * @return \Illuminate\Database\Eloquent\Factories\Factory
     */
    public function unverified()
    {
        return $this->state(function (array $attributes) {
            return [
                'email_verified_at' => null,
            ];
        });
    }
}
