import { useEffect, useState } from "react"
import { Table } from "react-bootstrap"
import Axios from "../apis/Axios"
import SlotMenu from "./slotMenu"

const Slots = () =>{

    const[slotovi,setSlotovi] = useState([])

    const getSlotovi = () =>{
        Axios.get("/slots")
        .then(res =>{
            setSlotovi(res.data)
            console.log(slotovi)
            setSlotovi(res.data)
        })
        .catch(error =>{
            console.log(error)
        })
    }

   

    useEffect(() =>{
        getSlotovi();
    },[])

    const renderSlots = () =>{
        return slotovi.map((slot) => {
            return <SlotMenu key = {slot.id} proslediId={slot.id}> </SlotMenu>
        })

    }


    return(
        <Table>
            <tbody>
               {renderSlots()}
                
            </tbody>
        </Table>
    )

}


export default Slots