import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map } from 'rxjs/operators';

export abstract class CrudService<T, ID> {

    constructor(
        protected _http: HttpClient,
        protected _base: string
    ) { }

    save(t: T): Observable<T> {
        return this._http.post<T>(this._base, t);
    }

    update(id: ID, t: T): Observable<T> {
        return this._http.put<T>(this._base + '/' + id, t, {});
    }

    updatePartial(id: ID, t: T): Observable<T> {
        return this._http.patch<T>(this._base + '/' + id, t, {});
    }

    findOne(id: ID): Observable<T> {
        return this._http.get<T>(this._base + '/' + id).pipe(map(item => {
            return item;
        }));
    }

    findAll(options: {params?: HttpParams}): Observable<T[]> {
        return this._http.get<T[]>(this._base, options);
    }

    delete(id: ID): Observable<T> {
        return this._http.delete<T>(this._base + '/' + id);
    }

}