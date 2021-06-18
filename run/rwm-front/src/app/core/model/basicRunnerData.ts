import { Injury } from "./injury";

export class BasicRunnerData {
    username : String;
    years: number;
    height: number;
    weight : number;
    gender : String;
    injuries: Injury[];

    constructor(username: String, years : number, height : number, weight: number,gender: String
        , injuries :Injury[] 
        ){
      this.username = username;
      this.years = years;
      this.height = height;
      this.weight = weight;
      this.gender = gender;
      this.injuries = injuries;
    }
}
