<?php

namespace App\Http\Controllers;

use App\Models\Barber;
use Illuminate\Http\Request;

class BarberController extends Controller
{
      // Show all barbers
      public function index()
      {
          $barbers = Barber::all();
          return view('admin.barbers.index', compact('barbers'));
      }
  
      // Show form to create a new barber
      public function create()
      {
          return view('admin.barbers.create');
      }
  
      // Store a new barber in the database
      public function store(Request $request)
      {
          $request->validate([
              'name' => 'required|string|max:255',
              'photo' => 'nullable|image|max:1024', // Image should be optional and limited in size
              'bio' => 'nullable|string',
              'available' => 'boolean',
          ]);
  
          $data = $request->all();
  
          // Handle photo upload
          if ($request->hasFile('photo')) {
              $data['photo'] = $request->file('photo')->store('photos', 'public');
          }
  
          Barber::create($data);
  
          return redirect()->route('barbers.index')->with('success', 'Barber added successfully.');
      }
  
      // Show form to edit an existing barber
      public function edit(Barber $barber)
      {
          return view('admin.barbers.edit', compact('barber'));
      }
  
      // Update the barber in the database
      public function update(Request $request, Barber $barber)
      {
          $request->validate([
              'name' => 'required|string|max:255',
              'photo' => 'nullable|image|max:1024',
              'bio' => 'nullable|string',
              'available' => 'boolean',
          ]);
  
          $data = $request->all();
  
          // Handle photo update
          if ($request->hasFile('photo')) {
              $data['photo'] = $request->file('photo')->store('photos', 'public');
          }
  
          $barber->update($data);
  
          return redirect()->route('barbers.index')->with('success', 'Barber updated successfully.');
      }
  
      // Delete a barber from the database
      public function destroy(Barber $barber)
      {
          $barber->delete();
  
          return redirect()->route('barbers.index')->with('success', 'Barber deleted successfully.');
      }
  }