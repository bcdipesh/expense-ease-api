-- Table: User

CREATE TABLE IF NOT EXISTS "User" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    "kindeUserId" VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255),
    "imageUrl" VARCHAR(255),
    "createdAt" TIMESTAMP DEFAULT NOW() NOT NULL,
    "updatedAt" TIMESTAMP DEFAULT NOW() NOT NULL
);

-- Table: Occasion

CREATE TABLE IF NOT EXISTS "Transaction" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    text VARCHAR(255) NOT NULL,
    amount FLOAT NOT NULL,
    "userId" VARCHAR(255) NOT NULL,
    "createdAt" TIMESTAMP DEFAULT NOW() NOT NULL
    "userId" VARCHAR(255) NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY ("userId") REFERENCES "User"("kindeUserId") ON DELETE CASCADE
);
