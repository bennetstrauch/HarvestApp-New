import axios from "axios";

// ----------------- AXIOS -----------------
// # export needed?

import { getUserId } from "./utils";

export const API = axios.create({
    baseURL: 'http://localhost:8181/api/v1/users/'
  })
  
const userId = getUserId();


  // to add id to baseURL   ## more elegant approach?
//   API.interceptors.request.use((config) => {
//     if (userId) {
//       config.baseURL = baseURL + userId +'/';
//     }
//     return config;
//   }, (error) => {
//     return Promise.reject(error);
//   });

  
  export const get = async (urlAddition) => {
    try {
        let data = [];
        data = (await API.get(userId + "/" + urlAddition)).data;
  
        console.log("Fetched data:" , data)
        return data;
    } catch (error) {
        console.log(error.message)
        return [];
    }
    
  }

  export const post = async (urlAddition, data) => {
    try {
        const response = await API.post(userId + "/" + urlAddition, data);
        console.log("Response from post", response);
        return response.data;
    } catch (error) {
        console.log(error.message);
        return null;
    }
  }
  
  // ## modify to add crops in filter.
  export async function getEntriesFilteredBy(dateRange) {
    const { startDate, endDate } = dateRange;

    const urlAddition = `harvest-entries/filter?startDate=${startDate}&endDate=${endDate}`;
    const response = await get(urlAddition);

    return response;
  }
  
  
  
  