import { NgxLoggerLevel } from 'ngx-logger';

// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  production: false,
  logLevel: NgxLoggerLevel.TRACE,
  serverLogLevel: NgxLoggerLevel.OFF,
  baseUrl: 'http://localhost:8080',
  login: 'auth/log-in',
  signUp: 'auth/sign-up',
  signUpAdmin: 'auth/sign-up-admin',
  signOut: 'auth/sign-out',
  changePassword: 'auth/change-password',
  runnerData : 'rwm/runner',
  cooper : 'rwm/runner/cooper',
  newRace : 'rwm/race/data',
};
