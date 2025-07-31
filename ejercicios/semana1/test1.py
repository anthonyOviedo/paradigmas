#!/usr/bin/env python3
import os
import sys
import json
import requests
from typing import List, Dict

HOST  = os.environ.get("OLLAMA_HOST",  "http://localhost:11434")
MODEL = os.environ.get("OLLAMA_MODEL", "deepseek-r1:8b")  # pick your model

# ---------- Ollama streaming ----------
def stream_request(prompt: str) -> str:
    payload = {
        "model":  MODEL,
        "prompt": prompt,
        "stream": True,   # important
        # "context": [...]  # you could manage context like llama.cpp if needed
    }

    full = []
    with requests.post(f"{HOST}/api/generate", json=payload, stream=True) as r:
        r.raise_for_status()
        for raw_line in r.iter_lines(decode_unicode=True):
            if not raw_line:
                continue
            try:
                chunk = json.loads(raw_line)
            except json.JSONDecodeError:
                continue

            token = chunk.get("response", "")
            if token:
                sys.stdout.write(token)
                sys.stdout.flush()
                full.append(token)

            if chunk.get("done"):
                break

    return "".join(full)

# ---------- Main loop ----------
def main():
    print(f"Chatting with {MODEL} at {HOST}. Type /exit to quit.\n")
    history: List[Dict[str, str]] = []

    while True:
        try:
            user = input("you> ").strip()
        except (EOFError, KeyboardInterrupt):
            print("\nbye.")
            break
        
        history.append({"role": "user", "content": user})

        print("ai > ", end="", flush=True)
        try:
            reply = stream_request(user)
        except Exception as e:
            print(f"\n[error] {e}")
            continue

        print("\n")  # end of model reply
        history.append({"role": "assistant", "content": reply})

if __name__ == "__main__":
    main()
