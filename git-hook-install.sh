#!/bin/bash

HOOK_FILE=".git/hooks/pre-commit"

# Create Pre-Commit Hook for Spotless
cat > "$HOOK_FILE" <<'EOF'
#!/bin/bash
# Spotless Apply vor jedem Commit
./gradlew spotlessApply
git add .
EOF

# Make the hook executable
chmod +x "$HOOK_FILE"

echo " ✅ Pre-commit Hook for Spotless has been installed successfully."