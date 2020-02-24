%% Polynom
p = [1, 5, -88, -404, 1872, 8064];
roots(p)


r = [-5, 3, 4, 9];
pol = poly(r)

x = linspace(-50, 50, 100);
y = polyval(pol, x);

hold on
axis([-10, 10, -50, 50])
plot(x, y)


%% Integraler

f = @(x)3 * exp(-0.3 * x) + 3 * cos(4 * x);
S = integral(f, 1, 2.5);

x = linspace(1, 2.5, 50);
y = f(x);

plot(x, y)


%% Min

g = @(x) cos(exp(x)) ./ (1 - x);
x = linspace(2, 3, 100);
y = g(x);
lm = islocalmin(y);

hold on
grid on
plot(x, y, x(lm), y(lm), 'r*');


%% Noll

h = @(x) 6 * x.^2 + x - exp(-x.^2);
x = linspace(-10, 10, 10000);
y = h(x);
zeroes = find(~y);
lm = islocalmin(y);
[xz0, yz0] = fzero(h, -1); %% Rätt????
[xz1, yz1] = fzero(h, 1);

hold on
grid on
axis([-1, 1, -10, 10])
plot(x, y, xz0, yz0, 'r*', xz1, yz1, 'r*', x(lm), y(lm), 'r*')


%% Diagonal

m = eye(7) * 3;
m1 = diag(diag(eye(6) * 2), 1);
m2 = diag(diag(eye(6) * 2), -1);
m = m + m1 + m2
det(m)