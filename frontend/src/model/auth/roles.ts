export enum userRole {
    ROLE_DOKTOR = 'ROLE_DOKTOR',
    ROLE_PACIJENT = 'ROLE_PACIJENT'
}

export const path = {
    [userRole.ROLE_DOKTOR]: '/doktor',
    [userRole.ROLE_PACIJENT]: '../pacijent'
}