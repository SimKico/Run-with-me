import { NumberValueAccessor } from "@angular/forms";

export class Cooper {
    username : String;
    distance : number;

    constructor(username : String, distance : number){
        this.username = username;
        this.distance = distance;
    }
}
