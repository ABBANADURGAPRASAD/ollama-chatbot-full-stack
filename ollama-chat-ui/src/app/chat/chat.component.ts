import { Component } from '@angular/core';
import { ChatService } from './chat.service';  // Adjust path if needed

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent {
  isSidebarOpen = true;
  message = '';
  messages: { sender: 'ai' | 'user'; text: string }[] = [
    { sender: 'ai', text: 'Hi! I’m the AI, how can I help?' }
  ];

  constructor(private chatService: ChatService) {}

  openSidebar() {
    this.isSidebarOpen = true;
  }

  closeSidebar() {
    this.isSidebarOpen = false;
  }

  newChat() {
    this.messages = [];
    this.message = '';
    console.log("New chat started");
  }

  searchChat() {
    // Implement search logic
    console.log("Search chat clicked");
  }

  openLibrary() {
    // Implement library logic
    console.log("Library clicked");
  }

  sendMessage() {
    if (this.message.trim() === '') return;
    this.messages.push({ sender: 'user', text: this.message });

    const userMessage = this.message;
    this.message = '';

    this.chatService.sendMessage(userMessage).subscribe({
      next: (response) => {
        this.messages.push({ sender: 'ai', text: response.message });
      },
      error: () => {
        this.messages.push({ sender: 'ai', text: 'Error: Could not get response from backend.' });
      }
    });
  }
}
