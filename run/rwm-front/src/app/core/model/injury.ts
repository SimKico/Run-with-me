export class Injury {
    username: String;
    dateOfInjury : any;
    injuryType: string;

    constructor(username : String, dateOfInjury : any, injuryType : string){
        this.username = username;
        this.dateOfInjury = dateOfInjury;
        this.injuryType = injuryType;
    }

}
