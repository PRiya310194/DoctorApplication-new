# DoctorApplication-new

#Requirements
.IntelliJIDEA

Serverport:8080(use localhost:8080)

java version 17

Everything is present in pom.xml(no need to download any library)
# Steps to run the Instagram 

Download the source code and import in intelliJIDEA.

Go to local host and eneter the end point.

DoctorId URL will have the fol
doctorName,City, email, phoneNumber,Speciality

PatientId url wii have

PatientName, city, email, phonenUmber, symptom

# Add doctor info-

In add userFunctionality we post user info through postman and get it added to the user.

end point is-

http://localhost:8080/save-doctor

# Get doctorByUserId-

In this we send particular userId and get that user info

ensdpoint is-

http://localhost:8080/doctor?doctorId=doctorId

# Get all doctor

This functionality provided all user
en dpoint is-http://localhost:8080/doctor

@Updata doctor

This functionality updates particulat user info through postman by sending userId in url

End point is-http://localhost:8080/save-doctor/{doctorId}

@DeleteUser by id-

This functionality deletes particulr user info through postman using the deletemethod by send ing the id in url

end point is-
http://localhost:8080/doctor/{doctorId}
