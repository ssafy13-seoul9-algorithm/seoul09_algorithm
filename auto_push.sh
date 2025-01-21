#!/bin/bash

base_dir=$(pwd)

find "$base_dir" -type f -name "*.java" | while read -r java_file; do
    file_name=$(basename "$java_file")

    num=$(echo "$file_name" | grep -oP 'w[0-9]_\K[0-9]+')
    user_name=$(echo "$file_name" | grep -oP '\K[USER_NAME]')

    if [ "$user_name" != "[USER_NAME]" ]; then
        continue
    fi

    if [ -z "$num" ]; then
        continue
    fi

    if git diff --quiet "$java_file"; then
	    continue
    fi

    commit_message="add: solution for SWEA #$num"
    
    echo "Processing: $file_name"
    git add "$java_file"
    echo "Added: $file_name"

    git commit -m "$commit_message"
    echo "Committed: $file_name with message: $commit_message"

    git push origin main
    echo "Pushed: $file_name to remote"
    echo "-------------------------------"
done

echo "All *.java files have been processed."
