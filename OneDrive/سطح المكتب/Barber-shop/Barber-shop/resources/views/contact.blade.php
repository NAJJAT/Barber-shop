<!-- resources/views/contact.blade.php -->
@extends('layouts.app')

@section('content')
    <div class="container">
        <h1>Contact Us</h1>
        <p>If you have any questions or comments, we would love to hear from you! Please fill out the form below:</p>

        <form action="" method="POST">
            @csrf
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" required>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="message">Message</label>
                <textarea id="message" name="message" rows="4" required></textarea>
            </div>

            <div class="form-group">
                <button type="submit">Send Message</button>
            </div>
        </form>

        <h2>Our Location</h2>
        <p>123 Barber Lane, Hair City, HC 12345</p>
        <h2>Phone</h2>
        <p>+1 (123) 456-7890</p>
    </div>
@endsection
