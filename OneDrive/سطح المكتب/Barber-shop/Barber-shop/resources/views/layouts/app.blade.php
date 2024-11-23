<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Barber Shop</title>
    <link rel="stylesheet" href="{{ asset('css/guest.css') }}">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                @guest
                    <li><a href="{{ route('home') }}">Home</a></li>
                    <li><a href="{{ route('services.index') }}">Services</a></li>
                    <li><a href="{{ route('user.booking.show') }}">Appointments</a></li>
                    <li><a href="{{ route('barbers.index') }}">Barbers</a></li>
                    <li><a href="{{ route('about') }}">About</a></li>
                    <li><a href="{{ route('contact') }}">Contact</a></li>
                    <li><a href="{{ route('login') }}">Login</a></li>
                    <li><a href="{{ route('register') }}">Register</a></li>
                @endguest
                @auth
                    @if(auth()->user()->isAdmin())
                        <!-- Visible only to admin users -->
                        <li><a href="{{ route('admin.dashboard') }}">Admin Dashboard</a></li>
                        <li><a href="{{ route('admin.services.index') }}">Manage Services</a></li>
                        <li><a href="{{ route('admin.barbers.index') }}">Manage Barbers</a></li>
                        <li><a href="{{ route('admin.bookings.index') }}">Manage Bookings</a></li>
                    @elseif(auth()->user()->isUser())
                        <!-- Visible only to regular users -->
                        <ul>
                            <li><a href="{{ route('home') }}">Home</a></li>
                            <li><a href="{{ route('barbers.index') }}">Barbers</a></li>
                            <li><a href="{{ route('user.services') }}">services</a></li>
                            <li><a href="{{ route('user.booking.show') }}">Appointments</a></li>
                            <li><a href="{{ route('about') }}">About</a></li>
                            <li><a href="{{ route('contact') }}">Contact</a></li>
                            <li><a href="{{ route('profile.edit') }}">Profile</a></li>                      
                            </li>
                        </ul>
                    @endif

                    <!-- Logout visible to all authenticated users -->
                    <li>
                        <form action="{{ route('logout') }}" method="POST">
                            @csrf
                            <button type="submit">Logout</button>
                        </form>
                    </li>
                @endguest
            </ul>
        </nav>
    </header>

    <main>
        @yield('content')
    </main>

    <footer>
        <p>&copy; {{ date('Y') }} Barber Shop. All Rights Reserved.</p>
    </footer>
</body>
</html>
