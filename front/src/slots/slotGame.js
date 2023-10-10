import {  useParams } from "react-router-dom";
import Axios from "../apis/Axios";
import { useEffect, useState } from "react";
import SlotTabla from "./slotTabla";


const SlotGame = (props) =>{
    const {broj} = useParams();

    const [slot,setSlot] = useState({})

    const[polja,setPolja]  = useState([])

    const[isplata,setIsplata] = useState([0])

    const[ulogDb,setUlog] = useState(1)

    const spin = () =>{
        console.log(ulogDb)
        console.log("ULOG")
        let id = broj 
        Axios.get("/slots/spin/" + id +"/"+ ulogDb)
        .then(res =>{
            setPolja(res.data.polja)
            setIsplata(res.data.isplata)
            props.balance()
            
            
        })
        .catch(error =>{
            console.log(error)
        })
    }
    
    const getSlot = () =>{

        Axios.get("/slots/" + broj).
        then(res =>{
           
            
            setSlot(res.data);
            
            console.log(res.data)
        })
        .catch(error =>{
            alert(error);
        })
    

    }

    
    useEffect(() =>{
        getSlot();
    },[])
    

    
    
    

    return(
        
        
        <SlotTabla ulog={ulogDb} balanceCheck={props.balanceCheck}  isplata = {isplata} setUlog = {(value) =>setUlog(value)} spin = {() =>spin()} polja = {polja} kolone = {slot.kolone}  redovi = {slot.redovi}></SlotTabla>
        
    )
}


export default SlotGame;