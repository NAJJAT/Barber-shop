<!-- resources/views/admin/services/index.blade.php -->

@extends('layouts.admin')

@section('title', 'Manage Services')

@section('content')
<h2>Manage Services</h2>
<a href="{{ route('admin.services.create') }}">Add New Service</a>

@if (session('success'))
    <div class="alert alert-success">{{ session('success') }}</div>
@endif

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        @foreach ($services as $service)
            <tr>
                <td>{{ $service->name }}</td>
                <td>{{ $service->description }}</td>
                <td>${{ $service->price }}</td>
                <td>
                    <a href="{{ route('admin.services.edit', $service) }}">Edit</a>
                    <form action="{{ route('admin.services.destroy', $service) }}" method="POST" style="display:inline;">
                        @csrf
                        @method('DELETE')
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </tbody>
</table>
@endsection
