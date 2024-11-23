<!-- resources/views/barbers/index.blade.php -->

@extends('layouts.app')

@section('content')
    <div class="container">
        <h1>Our Barbers</h1>

        @if($barbers->isEmpty())
            <p>No barbers are currently available. Please check back later.</p>
        @else
            <div class="barbers-list">
                @foreach($barbers as $barber)
                    <div class="barber-item">
                        <h2>{{ $barber->name }}</h2>
                        <p>{{ $barber->bio }}</p>
                        <p>Experience: {{ $barber->experience }} years</p>
                        <!-- Include any other relevant barber info here -->
                    </div>
                @endforeach
            </div>
        @endif
    </div>
@endsection
