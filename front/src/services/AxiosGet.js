import Axios from "../apis/Axios";

const GetAxios = (apiDestinacija) =>{

    Axios.get("/" + apiDestinacija)
    .then(res =>{
        console.log(res)
    })
    .catch(error =>{
        console.log(error)
    })




}

export default GetAxios;

