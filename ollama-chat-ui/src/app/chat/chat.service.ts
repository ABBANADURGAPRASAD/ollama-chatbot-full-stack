// chat.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ChatResponse {
  message: string;
}

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private apiUrl = 'http://localhost:8080/api/chat'; // Your Java backend endpoint

  constructor(private http: HttpClient) {}

  sendMessage(prompt: string): Observable<ChatResponse> {
    return this.http.post<ChatResponse>(this.apiUrl, { prompt, model: 'llama3' });
  }
}
