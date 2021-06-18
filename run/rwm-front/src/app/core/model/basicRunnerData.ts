import { Injury } from "./injury";

export class BasicRunnerData {
    years: number;
    height: number;
    weight : number;
    gender : String;
    // injuries: Injury[];

    constructor(years : number, height : number, weight: number,gender: String
        // , injuries :Injury[] 
        ){
      this.years = years;
      this.height = height;
      this.weight = weight;
      this.gender = gender;
    //   this.injuries = injuries;
    }
}
