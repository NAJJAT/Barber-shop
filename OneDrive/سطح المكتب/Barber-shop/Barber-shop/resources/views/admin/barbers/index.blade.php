@extends('layouts.app')

@section('title', 'Manage Barbers')

@section('content')
<h1>Manage Barbers</h1>
<a href="{{ route('admin.barbers.index') }}" class="btn btn-primary">Add New Barber</a>

@if (session('success'))
    <div class="alert alert-success">{{ session('success') }}</div>
@endif

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Photo</th>
            <th>Bio</th>
            <th>Available</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        @foreach ($barbers as $barber)
            <tr>
                <td>{{ $barber->name }}</td>
                <td><img src="{{ asset('storage/' . $barber->photo) }}" alt="{{ $barber->name }}" width="50"></td>
                <td>{{ $barber->bio }}</td>
                <td>{{ $barber->available ? 'Yes' : 'No' }}</td>
                <td>
                    <a href="{{ route('admin.barbers.edit', $barber) }}">Edit</a>
                    <form action="{{ route('admin.barbers.destroy', $barber) }}" method="POST" style="display:inline;">
                        @csrf
                        @method('DELETE')
                        <button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </tbody>
</table>
@endsection
