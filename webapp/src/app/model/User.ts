import { HotelOwner } from "./HotelOwner";
import { Customer } from "./Customer";
import { Admin } from "./Admin";


export class User {
    mailId?: string;
    password?: string;
    userName?: string;    
    status?: Customer | HotelOwner | Admin;  
  }
  