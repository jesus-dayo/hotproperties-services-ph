SET SQL_SAFE_UPDATES = 0;

update Images set image = REPLACE(image, 'hotprop-bucket.s3.ap-southeast-1.amazonaws.com', 'dyst1c8v98nm2.cloudfront.net')
WHERE image LIKE '%hotprop-bucket.s3.ap-southeast-1.amazonaws.com%';

commit;