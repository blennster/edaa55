m = complexmat(1000, -2 + 1i, 1 - 1i);
%m = complexmat(1000, -0.7 + 0.7i, -0.5 + 0.6i);
% m = complexmat(1000, -1.8 + 0.03i, -1.5 - 0.03i);
v = arrayfun(@converge, m);

image(v) % Auran kommer från att värdena konvergerar efter ett visst antal iterationer

