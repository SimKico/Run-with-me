export class Injury {
    dateOfInjury : Date;
    injuryType: string;
    runnerData : number;

    constructor(dateOfInjury : Date, injuryType : string, runnerData : number){
        this.dateOfInjury = dateOfInjury;
        this.injuryType = injuryType;
        this.runnerData = runnerData;
    }
}
