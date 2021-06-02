select name, date(start) as start from games
where Year(start) in (2011,2012)
order by start,name
limit 50;

select name, date_format(start, '%Y-%m-%d') as start from games
where Year(start) in (2011,2012)
order by start,name
limit 50;

select name, date_format(start, '%Y-%M-%D') as start from games
where Year(start) in (2011,2012)
order by start,name
limit 50;