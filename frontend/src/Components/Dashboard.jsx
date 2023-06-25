import {CreateBarber} from "./CreateBarber";
import {useEffect, useState} from "react";
import axios from "axios";
import {BarbersAppointmentTable} from "./BarbersAppointmentTable";
import {Navigation} from "./Navigation";

export const Dashboard =  () => {
    const [barbers, setBarbers] = useState([]);
    useEffect( () => {
        async function getBarbers() {
            const barbersResponse = await axios.get('http://localhost:8080/api/v1/barber');
            console.log(barbersResponse.data);
            setBarbers(barbersResponse.data);
        }
        getBarbers();
        console.log(barbers);

    }, [])

    return (
        <>
            <Navigation/>
            <h1>
                Dashboard
            </h1>
            <div className={'mb-2'}>
                <CreateBarber/>
            </div>
            <div>
                <BarbersAppointmentTable barbers={barbers} />
            </div>
        </>
    )
}