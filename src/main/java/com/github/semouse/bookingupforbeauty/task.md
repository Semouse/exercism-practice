In this exercise you'll be working on an appointment scheduler for a beauty salon in New York that
opened on September 15th in 2012.

1. **Parse appointment date**  
   Implement the AppointmentScheduler.schedule() method to parse a textual
   representation of an appointment date into the corresponding LocalDateTime
2. **Check if an appointment has already passed**  
   Implement the AppointmentScheduler.hasPassed() method that takes an appointment date and checks
   if the appointment was somewhere in the past
3. **Check if appointment is in the afternoon**  
   Implement the AppointmentScheduler.isAfternoonAppointment() method that takes an appointment date
   and checks if the appointment is in the afternoon (>= 12:00 and < 18:00)
4. **Describe the time and date of the appointment**  
   Implement the AppointmentScheduler.getDescription() method that takes an appointment date and
   returns a description of that date and time
5. **Return the anniversary date**  
   Implement the AppointmentScheduler.getAnniversaryDate() method that returns this year's
   anniversary date, which is September 15th
