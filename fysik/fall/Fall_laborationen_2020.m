% Emil Blennow
% Andrea Cicovic
% Anton Arvidsson

clear
clf
% Experimentella data
% data �r tiden (t) i s f�r olika fallstr�ckor (y) i m [t,y]
% OBS ta alltid med punkten 0,0
%
data=[     
    0.000	0.000   % 0,0 adderas manuellt - en bra punkt!!           
	0.154	0.100                   
	0.187	0.150
	0.215	0.200
	0.241	0.250
	0.263	0.300
	0.304	0.400
	0.340	0.500
	0.374	0.600
	0.403	0.700
	0.432	0.800
	0.459	0.900
	0.486	1.000
	0.547	1.250
	0.605	1.500
	0.660	1.750
	0.710	2.000
	0.813	2.500
	0.906	3.000
	0.992	3.500
	1.078	4.000
	1.244	5.000
	1.406	6.000
	1.573	7.000
	1.727	8.000
	1.889	9.000];
 %
 % F�rbered data
 y=data(:,2);
 t=data(:,1);
 [N,~]=size(t);
 
 %% Uppgift 1
 figure(1)
 p = polyfit(t, y, 4); % Anpassat polynom fr�n uppgift 3

 % Data punkter ska ALLTID ritas som "+" (helst med felstaplar men det g�r vi inte h�r)
 hold on
 plot(t,y,'+')
 plot(t, polyval(p, t))
 axis([-.1 2 -.2 9.2])
 
 % Axlarna ska ALLTID betecknas med "Storhetsbeteckning / enhet" d�r Storhetsbeteckning ska vara kursiv (\it)
 % Kommandot \rm �terst�ller till icke kursiv
 xlabel('\itt\rm / s')    
 ylabel('\ity\rm / m')
 title('Fallstr�ckan som funktion av tiden')
 legend('M�tv�rden', 'Anpassat polynom')
 
 hold off
 
 %% Uppgift 2
 figure(2)
 
 vt = diff(y) ./ diff(t); % Numerisk derivata
 vt = [0 ;vt]; % L�gg till nolla f�rst
 
 plot(t, vt, '+')
 
 xlabel('\itt\rm / s')    
 ylabel('\itv\rm / m/s')
 axis([-.1 2 -.2 8])
 title('Hastigheten som funktion av tiden')
 
 %% Uppgift 3
 
 figure(3)
 
 pprim = polyder(p); % Derivera anpassat polynom f�r att f� hastighet
 vgrans = max(polyval(pprim, t)); % Gr�nshastighet
 
 hold on
 plot(t, vt, '+')
 plot(t, polyval(pprim, t))
 legend('Numerisk derivering av m�tv�rden', 'Derivata av anpassat polynom till m�tv�rden')
 
 xlabel('\itt\rm / s')
 ylabel('\itv\rm / m/s')
 axis([-.1 2 -.2 8])
 title('Hastigheten som funktion av tiden')
 
 figure(4)
 
 acc = polyder(pprim); % Derivata av hastighet
 
 plot(t, polyval(acc, t))
 xlabel('\itt\rm / s')
 ylabel('\itv\rm / m/s^2')
 title('Acceleration som funktion av tiden')
 legend('Andraderivata av anpassat polynom')

 
 %% Uppgift 4
 Fg = 9.82;
 m = 0.005;
 
 b = m * Fg/ vgrans;
 B = m * Fg/ vgrans^2;
 
 Ff = @(v) 0; 
 [sy1, sv1, sa1] = simulate(Ff, Fg, m);
 
 Ff = @(v) b * v;
 [sy2, sv2, sa2] = simulate(Ff, Fg, m);

 Ff = @(v) B * v^2;
 [sy3, sv3, sa3] = simulate(Ff, Fg, m);

 
 tid = linspace(0,2); 
 
 figure(1)
 hold on
 plot(tid, sy1)
 plot(tid, sy2)
 plot(tid, sy3)
 plot(t, y, '+')
 
 xlabel('\itt\rm / s')    
 ylabel('\ity\rm / m')
 legend('Ff = 0', 'Ff = -b * v', 'Ff = -B * v^2', 'M�tv�rden')

 title('Fallstr�ckan som funktion av tiden')

 
 figure(2)
 hold on
 plot(tid, sv1)
 plot(tid, sv2)
 plot(tid, sv3)
 plot(t, vt, '+')
 
 xlabel('\itt\rm / s')
 ylabel('\itv\rm / m/s')
 legend('Ff = 0', 'Ff = -b * v', 'Ff = -B * v^2', 'M�tv�rden')

 title('Hastigheten som funktion av tiden')

 
 figure(3)
 hold on
 plot(tid, sa1)
 plot(tid, sa2)
 plot(tid, sa3)
 
 xlabel('\itt\rm / s')
 ylabel('\itv\rm / m/s^2')
 legend('Ff = 0', 'Ff = -b * v', 'Ff = -B * v^2')

 title('Acceleration som funktion av tiden')
 