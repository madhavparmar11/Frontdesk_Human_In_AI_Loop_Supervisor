@echo off
echo Starting LiveKit Server...

REM Download LiveKit server if not exists
if not exist livekit-server.exe (
    echo Downloading LiveKit server...
    curl -L -o livekit-server.exe https://github.com/livekit/livekit/releases/latest/download/livekit_windows_amd64.exe
)

REM Create config file
echo Creating LiveKit config...
(
echo port: 7880
echo rtc:
echo   tcp_port: 7881
echo   port_range_start: 50000
echo   port_range_end: 60000
echo   use_external_ip: false
echo keys:
echo   devkey: secret
echo room:
echo   auto_create: true
echo   enable_recording: false
echo turn:
echo   enabled: false
) > livekit.yaml

echo Starting LiveKit server on port 7880...
livekit-server.exe --config livekit.yaml