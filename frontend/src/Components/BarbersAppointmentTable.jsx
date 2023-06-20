import {Table} from 'react-bootstrap';
import {RendevouzTable} from "./RendevouzTable";
export const BarbersAppointmentTable = (props) => {
    return (
        <>
            {props.barbers.map(
                barber => {return <diu className={'mb-2'}>
                    <h2>{barber.name}</h2>
                    <RendevouzTable barberId={barber.id} barbersName={barber.name} />
                </diu>
                }

            )}

        </>
    )
}