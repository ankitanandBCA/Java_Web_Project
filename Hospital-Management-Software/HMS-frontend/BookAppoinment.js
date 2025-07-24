async function handleSubmit(event)
{
    event.preventDefault();

    const name=document.getElementById("patientName").value;
    const email=document.getElementById("email").value;
    const mobile=document.getElementById("mobile").value;
    const address=document.getElementById("address").value;
    const specilist=document.getElementById("specialist").value;
    const appoinment_date=document.getElementById("appointmentDate").value;
    const time=document.getElementById("appointmentTime").value;
    const description=document.getElementById("reason").value;


    const doctor={name,email,mobile,address,specilist,appoinment_date,time,description}
    console.log(JSON.stringify(doctor));


    const baseURL="http://localhost:8080/Appoinment/Book";

       try{
         const response=await fetch(baseURL,{
           method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(doctor),
         });
           if(response.ok)
           {
            alert("Appoinment Book Sucessfull.........");
           }
           else{
            alert("Appoinment not Book");
           }

       }catch(error)
       {
        console.log(error);
        
       }
    
}