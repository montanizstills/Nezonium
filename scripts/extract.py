#!/usr/bin/env python3
"""
extract_names.py

Accepts the fully-qualified path to a guest cards CSV file and prints/returns
the guest name derived from the 3rd column ("Name and Address").

Logic:
  - Take everything in the 3rd column up to the first "<br>" tag -> this is
    the "name pattern".
  - Split the name pattern on whitespace.
      * If there are exactly 3 tokens (First Middle Last), keep only the
        first and last (drop the middle).
      * Otherwise, keep the tokens as-is (e.g. 2 tokens: First Last already).
  - Output as "First, Last"

Usage:
    python extract_names.py /full/path/to/guest_cards.csv
"""

import csv
import sys


def extract_name(name_and_address: str) -> str:
    """Given the raw 'Name and Address' field, return 'First, Last'."""
    # First pattern up until the <br> tag
    name_pattern = name_and_address.split('<br>')[0].strip()

    tokens = name_pattern.split()

    if len(tokens) == 3:
        # First Middle Last -> drop the middle
        first, last = tokens[0], tokens[2]
    elif len(tokens) >= 2:
        # Assume first token is First, last token is Last
        first, last = tokens[0], tokens[-1]
    elif len(tokens) == 1:
        first, last = tokens[0], ''
    else:
        first, last = '', ''

    if last:
        return f"{first}, {last}"
    return first


def process_file(fqn_path: str):
    names = []
    with open(fqn_path, encoding='cp1252', newline='') as f:
        reader = csv.DictReader(f)
        for row in reader:
            raw = row.get('Name and Address', '')
            if not raw:
                continue
            names.append(extract_name(raw))
    return names


def main():
    if len(sys.argv) != 2:
        print("Usage: python extract_names.py <full_path_to_csv>")
        sys.exit(1)

    fqn_path = sys.argv[1]
    names = process_file(fqn_path)

    for name in names:
        print(name)


if __name__ == '__main__':
    # main()
    names =  process_file(r'C:\Users\Mstills\Downloads\guest_cards.csv')
    print(names)