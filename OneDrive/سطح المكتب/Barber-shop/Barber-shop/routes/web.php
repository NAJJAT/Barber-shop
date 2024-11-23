<?php

use App\Http\Controllers\ProfileController;
use App\Http\Controllers\BookingController;
use App\Http\Controllers\ServiceController;
use App\Http\Controllers\BarberController;
use App\Http\Controllers\AdminController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/



Route::get('/', function () {
    return view('welcome');
})->name('home');

// Login Route
Route::get('/login', function () {
    return view('views.auth.login')->name('login');
});

// Register Route
Route::get('/register', function () {
    return view('views.auth.register')->name('register');
});

// Logout Route
Route::get('/logout', function () {
    auth()->logout();
    return redirect()->route('home');
});


// Guest routes
Route::get('/services', [ServiceController::class, 'index'])->name('services.index');
Route::get('/barbers', [BarberController::class, 'index'])->name('barbers.index');

// routes/web.php
Route::get('/about',function(){
    return view('about');
})->name('about');
Route::get('/contact',function(){
    return view('contact');
})->name('contact');


Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
    Route::get('/booking/{service}', [BookingController::class, 'create'])->name('booking.create');

});


Route::middleware(['auth', 'user'])->group(function () {
    Route::get('/dashboard', [UserController::class, 'index'])->name('user.dashboard');
    Route::get('/user/services', [UserController::class, 'services'])->name('user.services'); // View services
    Route::get('/user/bookings', [UserController::class, 'bookings'])->name('user.bookings'); // User's bookings
    //views the appointment for the current user
    Route::get('user/booking/show', [BookingController::class, 'show'])->name('user.booking.show');
    Route::get('/booking/{id}', [BookingController::class, 'show'])->name('booking.show');


    //views the form to create a new appointment for the current user                                                                                                                               
    Route::get('/user/bookings/create', [UserController::class, 'createBooking'])->name('user.booking.create'); // Create booking
    //stores the new appointment for the current user
    Route::post('/user/bookings/store', [UserController::class, 'storeBooking'])->name('user.bookings.store'); // Store booking
    //views the form to edit the current appointment for the current user
    Route::get('/user/bookings/{id}/edit', [UserController::class, 'editBooking'])->name('user.bookings.edit'); // Edit booking
    //updates the current appointment for the current user
    Route::put('/user/bookings/{id}', [UserController::class, 'updateBooking'])->name('user.bookings.update');
    Route::get('/user/bookings/create', [UserController::class, 'createBooking'])->name('user.bookings.create'); // Create booking
    Route::post('/user/bookings/store', [UserController::class, 'storeBooking'])->name('user.bookings.store'); // Store booking
    Route::get('/user/bookings/{id}/edit', [UserController::class, 'editBooking'])->name('user.bookings.edit'); // Edit booking
    Route::put('/user/bookings/{id}', [UserController::class, 'updateBooking'])->name('user.bookings.update'); // Update booking
    Route::delete('/user/bookings/{id}', [UserController::class, 'destroyBooking'])->name('user.bookings.destroy'); // Delete booking
});
// Admin routes
Route::middleware(['auth', 'admin'])->group(function () {
    Route::get('/admin/dashboard', [AdminController::class, 'index'])->name('admin.dashboard');
    // Service routes
    Route::get('admin/services/create', [ServiceController::class, 'create'])->name('admin.services.index');
    Route::post('admin/services', [ServiceController::class,'store'])->name('admin.services.store');
    Route::get('admin/services/{service}/edit', [ServiceController::class, 'edit'])->name('admin.services.edit');
    Route::put('admin/services/{service}', [ServiceController::class, 'update'])->name('admin.services.update');
    Route::delete('admin/services/{service}', [ServiceController::class, 'destroy'])->name('admin.services.destroy');
    Route::get('admin/services/{service}/delete', [ServiceController::class, 'delete'])->name('admin.services.delete');
    //admin routes for barbers
    Route::get('admin/barbers/create', [BarberController::class, 'create'])->name('admin.barbers.index');
    Route::post('admin/barbers', [BarberController::class,'store'])->name('admin.barbers.store');
    Route::get('admin/barbers/{barber}/edit', [BarberController::class, 'edit'])->name('admin.barbers.edit');
    Route::put('admin/barbers/{barber}', [BarberController::class, 'update'])->name('admin.barbers.update');
    Route::delete('admin/barbers/{barber}', [BarberController::class, 'destroy'])->name('admin.barbers.destroy');
    Route::get('admin/barbers/{barber}/delete', [BarberController::class, 'delete'])->name('admin.barbers.delete');
    // admin routes for bookings
    Route::get('admin/bookings', [BookingController::class, 'index'])->name('admin.bookings.index');
    Route::get('admin/bookings/{booking}/edit', [BookingController::class, 'edit'])->name('admin.bookings.edit');
    Route::post('admin/bookings', [BookingController::class, 'store'])->name('admin.bookings.store');
    Route::get('admin/bookings/create', [BookingController::class, 'create'])->name('admin.bookings.create');
    Route::get('admin/bookings/{booking}', [BookingController::class, 'show'])->name('admin.bookings.show');
    Route::put('admin/bookings/{booking}', [BookingController::class, 'update'])->name('admin.bookings.update');
    Route::delete('admin/bookings/{booking}', [BookingController::class, 'destroy'])->name('admin.bookings.destroy');
    Route::get('admin/bookings/{booking}/delete', [BookingController::class, 'delete'])->name('admin.bookings.delete');


});


require __DIR__.'/auth.php';

