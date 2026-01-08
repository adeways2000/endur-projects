# CI/CD Pipeline for Endur Customizations

## 1. Workflow Overview
This pipeline automates the testing and deployment of OpenJVS and OpenComponents code to the enterprise Endur environments.

## 2. GitHub Actions Workflow (`.github/workflows/endur-deploy.yml`)

```yaml
name: Endur Customization Deployment

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]

jobs:
  build-and-test:
    runs-on: windows-latest # Required for .NET OpenComponents
    
    steps:
    - uses: actions/checkout@v2

    - name: Setup .NET
      uses: actions/setup-dotnet@v1
      with:
        dotnet-version: '6.0.x'

    - name: Build OpenComponents
      run: dotnet build ./opencomponents/RiskCalculator.csproj --configuration Release

    - name: Run JVS Linting
      run: |
        echo "Running JVS syntax check..."
        # Custom JVS compiler check simulation
        python ./scripts/check_jvs_syntax.py ./jvs/

    - name: Deploy to UAT
      if: github.ref == 'refs/heads/develop'
      run: python ./scripts/deploy_customizations.py --env UAT

    - name: Deploy to PROD
      if: github.ref == 'refs/heads/main'
      run: python ./scripts/deploy_customizations.py --env PROD
```

## 3. Key Features
- **Automated Linting**: Ensures JVS scripts follow enterprise coding standards.
- **Environment Isolation**: Separate deployment logic for UAT and Production.
- **Rollback Capability**: Version-controlled deployments allow for quick reverts in case of production issues.
