var wavesurfer = WaveSurfer.create({
  container: '#waveform',
  waveColor: '#800000',
  progressColor: 'purple'
});

wavesurfer.load(document.currentScript.getAttribute('one'));



