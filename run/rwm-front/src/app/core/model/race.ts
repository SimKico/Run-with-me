export class Race {
    username : String;
    raceDate : any;
    raceLocation : String;
    timeGoal : String;

    constructor(username: String, raceDate: any, raceLocation: String, timeGoal:String){
        this.username = username;
        this.raceDate = raceDate;
        this.raceLocation = raceLocation;
        this.timeGoal  = timeGoal;
    }
    
}
