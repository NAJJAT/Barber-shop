@extends('layouts.admin')

@section('title', 'Create Booking')

@section('content')
<h2>Create Booking</h2>

@if (session('success'))
    <div class="alert alert-success">{{ session('success') }}</div>
@endif

<!-- Calendar Container -->
<div id='calendar'></div>

<!-- Hidden Form for Booking -->
<div id="booking-form" style="display:none;">
    <form id="createBooking" method="POST" action="{{ route('admin.bookings.store') }}">
        @csrf
        <input type="hidden" name="service_id" id="serviceId">
        <input type="hidden" name="barber_id" id="barberId">
        <input type="hidden" name="date" id="bookingDate">
        <input type="hidden" name="time" id="bookingTime">

        <div>
            <label for="customerName">Customer Name:</label>
            <input type="text" name="customer_name" required>
        </div>
        <div>
            <label for="customerEmail">Customer Email:</label>
            <input type="email" name="customer_email" required>
        </div>
        <button type="submit">Create Booking</button>
    </form>
</div>

@endsection

@section('scripts')
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');

        var calendar = new FullCalendar.Calendar(calendarEl, {
            plugins: [ 'dayGrid', 'timeGrid', 'interaction' ],
            headerToolbar: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay'
            },
            initialView: 'timeGridWeek',
            editable: true,
            selectable: true,
            select: function(info) {
                // Get the date and time selected
                var selectedDate = info.startStr.split('T')[0];
                var selectedTime = info.startStr.split('T')[1].substring(0, 5);
                
                // Show the booking form
                document.getElementById('booking-form').style.display = 'block';
                document.getElementById('bookingDate').value = selectedDate;
                document.getElementById('bookingTime').value = selectedTime;

                // Optionally, set service and barber IDs if you want
                document.getElementById('serviceId').value = '1'; // Example service ID
                document.getElementById('barberId').value = '1'; // Example barber ID
            },
            events: [] // Add your events here if you have any pre-existing bookings
        });

        calendar.render();
    });
</script>
@endsection
